class Solution(object):
    def combinationSum(self, candidates, target):
        result = []

        def backtrack(start, current_combo, remaining_target):
            if remaining_target == 0:
                result.append(list(current_combo))
                return
            elif remaining_target < 0:
                return  # Overshot the target, go back

            for i in range(start, len(candidates)):
                current_combo.append(candidates[i])
                backtrack(i, current_combo, remaining_target - candidates[i])
                current_combo.pop()  # Undo the last step (backtrack)

        backtrack(0, [], target)
        return result

        