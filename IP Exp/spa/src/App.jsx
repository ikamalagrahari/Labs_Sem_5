import React from 'react';
import { BrowserRouter as Router, Route, Routes, NavLink, useParams } from 'react-router-dom';

// Home Component
function Home() {
  return <h2>Home Page</h2>;
}

// About Component with Nested Routes
function About() {
  return (
    <div>
      <h2>About Us</h2>
      <p>Welcome to the About Page.</p>
      <ul>
        <li>
          <NavLink to="/about/team" className={({ isActive }) => (isActive ? 'active' : '')}>Our Team</NavLink>
        </li>
        <li>
          <NavLink to="/about/history" className={({ isActive }) => (isActive ? 'active' : '')}>Our History</NavLink>
        </li>
      </ul>
    </div>
  );
}

// Team Component
function Team() {
  return <h3>Meet our dedicated team.</h3>;
}

// History Component
function History() {
  return <h3>We have a rich history dating back 50 years.</h3>;
}

// User Profile Component for Dynamic Routing
function UserProfile() {
  const { username } = useParams();
  return <h2>Welcome to {username}'s profile!</h2>;
}

// Not Found Component for 404 handling
function NotFound() {
  return <h2>404 - Page Not Found</h2>;
}

// Main App Component
function App() {
  return (
    <Router>
      <div className="container">
        <nav className="nav-bar">
          <NavLink to="/" className={({ isActive }) => (isActive ? 'active' : '')}>Home</NavLink>
          <NavLink to="/about" className={({ isActive }) => (isActive ? 'active' : '')}>About</NavLink>
          <NavLink to="/user/john" className={({ isActive }) => (isActive ? 'active' : '')}>User Profile (John)</NavLink>
        </nav>

        {/* Switch replaced with Routes in v6 */}
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/about/team" element={<Team />} />
          <Route path="/about/history" element={<History />} />
          {/* Dynamic Route for user profiles */}
          <Route path="/user/:username" element={<UserProfile />} />
          {/* 404 Route */}
          <Route path="*" element={<NotFound />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
