import React, { useState } from 'react';

function Counter(props) {
  const [count, setCount] = useState(props.initialCount); // Use prop as initial state

  return (
    <div>
      <h1>Count: {count}</h1>
      <button onClick={() => setCount(count + 1)}>Increment</button>
    </div>
  );
}

export default Counter;
