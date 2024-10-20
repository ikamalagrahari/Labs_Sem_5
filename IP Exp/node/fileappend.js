// fileappend.js
const fs = require('fs');
// i) Append some text to an existing file
fs.appendFile('example.txt', '\nThis is the appended text.', (err) =>
{
if (err) throw err;
console.log('Text appended successfully.');
// ii) Rename the file
fs.rename('example.txt', 'renamed-example.txt', (err) => {
if (err) throw err;
console.log('File renamed successfully.');
});
});