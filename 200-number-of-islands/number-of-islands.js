// var numIslands = function(grid) {
//     if (!grid || grid.length === 0) return 0;//checks for null

//     const rows = grid.length;
//     const cols = grid[0].length;
//     let count = 0;
//     //here we checks for the group of 1's to get the count of the island
//     const dfs = (r, c) => {
//         if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] === '0') return;
//         grid[r][c] = '0';
//         dfs(r + 1, c);
//         dfs(r - 1, c);
//         dfs(r, c + 1);
//         dfs(r, c - 1);
//     };
//     //here chacking the rows,clos to get the 1 and increment the count
//     for (let i = 0; i < rows; i++) {
//         for (let j = 0; j < cols; j++) {
//             if (grid[i][j] === '1') {
//                 count++;
//                 dfs(i, j);
//             }
//         }
//     }

//     return count;
// };


var numIslands = function(grid){
    if(!grid || grid.length === 0) return;

    const row = grid.length;
    const col = grid[0].length; let count = 0;

   const dfs= (r,c) => {

    if(r < 0 || c < 0 || r >= row || c >= col || grid[r][c] === '0')return ;
    grid[r][c] = '0';
    dfs(r + 1, c);
    dfs(r - 1, c);
    dfs(r, c + 1);
    dfs(r, c - 1);
   };

   for(let i=0; i< row; i++){
    for(let j=0; j< col; j++){
        if(grid[i][j]=== '1'){
            count++;
            dfs(i,j);
        }
    }
   }
   return count;
}