// buffer.js
const buffer = Buffer.from('Hello, Buffer in Node.js!');
console.log('Buffer Content:', buffer);
console.log('Buffer to String:', buffer.toString());
console.log('Buffer Length:', buffer.length);
// Create an empty buffer of 10 bytes
const emptyBuffer = Buffer.alloc(10);
console.log('Empty Buffer:', emptyBuffer);
// Write to buffer
buffer.write('Node.js');
console.log('Modified Buffer:', buffer.toString());