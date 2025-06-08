// The cache[rows] = adjacency list of compatible column-patterns
const compatibilityListCache = {};

function ensureCompatibilityList(rows) {
  if (compatibilityListCache[rows]) {
    return compatibilityListCache[rows];
  }

  const validColumnPatterns = [];
  const currentPattern = new Array(rows);

  function generatePatterns(position) {
    if (position === rows) {
      validColumnPatterns.push(currentPattern.slice());
      return;
    }

    for (let colorIndex = 0; colorIndex < 3; colorIndex++) {
      if (position > 0 && currentPattern[position - 1] === colorIndex) {
        continue;
      }

      currentPattern[position] = colorIndex;
      generatePatterns(position + 1);
    }
  }

  generatePatterns(0);

  const patternCount = validColumnPatterns.length;
  const compatibilityAdjacencyList = Array.from({ length: patternCount }, () => []);

  for (let firstPatternIndex = 0; firstPatternIndex < patternCount; firstPatternIndex++) {
    const firstPattern = validColumnPatterns[firstPatternIndex];

    for (let secondPatternIndex = 0; secondPatternIndex < patternCount; secondPatternIndex++) {
      const secondPattern = validColumnPatterns[secondPatternIndex];
      let isCompatible = true;

      for (let rowIndex = 0; rowIndex < rows; rowIndex++) {
        if (firstPattern[rowIndex] === secondPattern[rowIndex]) {
          isCompatible = false;
          break;
        }
      }

      if (isCompatible) {
        compatibilityAdjacencyList[firstPatternIndex].push(secondPatternIndex);
      }
    }
  }

  compatibilityListCache[rows] = compatibilityAdjacencyList;
  return compatibilityAdjacencyList;
}

function colorTheGrid(rowCount, columnCount) {
  const MODULO = 1000000007;

  const compatibilityAdjacencyList = ensureCompatibilityList(rowCount);
  const patternCount = compatibilityAdjacencyList.length;

  let waysForPreviousColumn = Array(patternCount).fill(1);
  let waysForCurrentColumn = Array(patternCount).fill(0);

  for (let columnIndex = 1; columnIndex < columnCount; columnIndex++) {
    waysForCurrentColumn.fill(0);

    for (let previousPatternIndex = 0; previousPatternIndex < patternCount; previousPatternIndex++) {
      const waysCount = waysForPreviousColumn[previousPatternIndex];
      if (waysCount === 0) continue;

      const compatibleNextPatterns = compatibilityAdjacencyList[previousPatternIndex];
      for (let i = 0; i < compatibleNextPatterns.length; i++) {
        const nextPatternIndex = compatibleNextPatterns[i];
        let updatedWays = waysForCurrentColumn[nextPatternIndex] + waysCount;

        if (updatedWays >= MODULO) {
          updatedWays -= MODULO;
        }

        waysForCurrentColumn[nextPatternIndex] = updatedWays;
      }
    }

    const temp = waysForPreviousColumn;
    waysForPreviousColumn = waysForCurrentColumn;
    waysForCurrentColumn = temp;
  }

  let totalWays = 0;
  for (let i = 0; i < patternCount; i++) {
    totalWays += waysForPreviousColumn[i];
    if (totalWays >= MODULO) {
      totalWays -= MODULO;
    }
  }

  return totalWays;
}
