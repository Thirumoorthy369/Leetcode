function spellchecker(wordlist: string[], queries: string[]): string[] {
  const vowels = new Set(['a', 'e', 'i', 'o', 'u']);

  const normalizeVowels = (word: string): string =>
    word.toLowerCase().replace(/[aeiou]/g, '*');

  // Step 1: Build maps
  const exactWords = new Set<string>(wordlist);
  const caseInsensitiveMap = new Map<string, string>();
  const vowelMap = new Map<string, string>();

  for (const word of wordlist) {
    const lower = word.toLowerCase();
    const masked = normalizeVowels(word);

    if (!caseInsensitiveMap.has(lower)) {
      caseInsensitiveMap.set(lower, word);
    }
    if (!vowelMap.has(masked)) {
      vowelMap.set(masked, word);
    }
  }

  // Step 2: Process queries
  const results: string[] = [];
  for (const query of queries) {
    if (exactWords.has(query)) {
      results.push(query);
    } else {
      const lower = query.toLowerCase();
      const masked = normalizeVowels(query);

      if (caseInsensitiveMap.has(lower)) {
        results.push(caseInsensitiveMap.get(lower)!);
      } else if (vowelMap.has(masked)) {
        results.push(vowelMap.get(masked)!);
      } else {
        results.push("");
      }
    }
  }

  return results;
}
