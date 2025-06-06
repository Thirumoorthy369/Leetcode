/**
 * @param {number[][]} moves
 * @return {string}
 */
var tictactoe = function(moves) {
    const n = 3;
    const rows = new Array(n).fill(0);
    const cols = new Array(n).fill(0);
    
    let diagnol = 0
    let anti_diag = 0;
    let player = 1

    for(const move of moves){
        const r = move[0]
        const c = move[1]

        rows[r] += player
        cols[c] += player

        if(c === r) diagnol += player
        if(r + c === n-1) anti_diag += player

        if(Math.abs(rows[r]) === n || Math.abs(cols[c]) === n || Math.abs(diagnol) === n || Math.abs(anti_diag) === n){
            return player === 1 ? 'A' : 'B';
        }

        player *= -1
    }

    return moves.length === n*n ? "Draw" : "Pending"
};