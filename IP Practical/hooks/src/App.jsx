import React, { useState, useEffect, useRef } from 'react';

function App() {
  const [count, setCount] = useState(0);
  const inputRef = useRef(null);

  useEffect(() => {
    document.title = `You clicked ${count} times`;
  }, [count]);

  return (
    <div className="min-h-screen flex flex-col items-center justify-center bg-gray-100 p-4">
      <div className="bg-white shadow-md rounded-lg p-6 w-full max-w-md text-center">
        <h1 className="text-2xl font-semibold mb-4">Count: {count}</h1>
        <button 
          onClick={() => setCount(count + 1)} 
          className="px-4 py-2 bg-blue-500 text-white rounded-lg hover:bg-blue-600 transition duration-300 mb-4"
        >
          Increment
        </button>

        <div className="mb-4">
          <input 
            ref={inputRef} 
            className="w-full p-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500" 
            placeholder="Focus on me" 
          />
        </div>
        
        <button 
          onClick={() => inputRef.current.focus()} 
          className="px-4 py-2 bg-green-500 text-white rounded-lg hover:bg-green-600 transition duration-300"
        >
          Focus Input
        </button>
      </div>
    </div>
  );
}

export default App;
