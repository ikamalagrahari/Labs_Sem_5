// asyncprogramming.js
const fs = require('fs');
// Asynchronous file reading
fs.readFile('renamed-example.txt', 'utf8', (err, data) => {
if (err) {
console.log('Error reading file:', err);
return;
}
console.log('File content read asynchronously:', data);
});
// Simulating asynchronous operation using setTimeout
console.log('Start');
setTimeout(() => {
console.log('Asynchronous operation complete after 2 seconds');
}, 2000);
console.log('End');
