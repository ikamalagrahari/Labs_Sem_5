// filecreate.js
const fs = require('fs');
//  Create a file and write a paragraph into it
fs.writeFile('example.txt', 'This is a sample paragraph written to the file.', (err) => {
if (err) throw err;
console.log('File created and paragraph written successfully.');
});