const maxAverageRatio = (classes: number[][], extraStudents: number): number => {
    const maxHeap = new PriorityQueue<[number, number, number]>((a, b) => b[2] - a[2]);

    for (const [passingStudents, totalStudents] of classes) {
        const currentRatio = passingStudents / totalStudents;
        const improvedRatio = (passingStudents + 1) / (totalStudents + 1);
        const improvementGain = improvedRatio - currentRatio;
        maxHeap.push([passingStudents, totalStudents, improvementGain]);
    }

    let remainingStudents = extraStudents;
    while (remainingStudents > 0) {
        const [passingStudents, totalStudents, _] = maxHeap.pop();
        
        const newPassingStudents = passingStudents + 1;
        const newTotalStudents = totalStudents + 1;
        
        const currentRatio = newPassingStudents / newTotalStudents;
        const improvedRatio = (newPassingStudents + 1) / (newTotalStudents + 1);
        const newImprovementGain = improvedRatio - currentRatio;
        
        maxHeap.push([newPassingStudents, newTotalStudents, newImprovementGain]);
        remainingStudents--;
    }

    let totalPassRatio = 0;
    while (maxHeap.size() > 0) {
        const [passingStudents, totalStudents, _] = maxHeap.pop();
        totalPassRatio += passingStudents / totalStudents;
    }
    
    return totalPassRatio / classes.length;
};