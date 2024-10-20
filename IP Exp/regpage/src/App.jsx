import React, { useState } from 'react';

function App() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
    gender: '',
    dob: '',
    fatherName: '',
    motherName: '',
    phoneNumber: '',
    address: '',
  });
  const [errors, setErrors] = useState({});

  const validate = () => {
    const newErrors = {};
    if (!formData.name) newErrors.name = "Name is required";
    if (!formData.email) newErrors.email = "Email is required";
    if (!formData.password || formData.password.length < 6) 
      newErrors.password = "Password must be at least 6 characters long";
    if (!formData.gender) newErrors.gender = "Gender is required";
    if (!formData.dob) newErrors.dob = "Date of Birth is required";
    if (!formData.fatherName) newErrors.fatherName = "Father's Name is required";
    if (!formData.motherName) newErrors.motherName = "Mother's Name is required";
    if (!formData.phoneNumber) newErrors.phoneNumber = "Phone Number is required";
    if (!formData.address) newErrors.address = "Address is required";

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (validate()) {
      alert("Form submitted successfully!");
      setFormData({
        name: '',
        email: '',
        password: '',
        gender: '',
        dob: '',
        fatherName: '',
        motherName: '',
        phoneNumber: '',
        address: '',
      });
      setErrors({});
    }
  };

  return (
    <div className="max-w-md mx-auto mt-10 bg-white p-8 rounded-xl shadow-md">
      <h2 className="text-lg font-bold mb-4">Registration Form</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-4">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="name">
            Name:
          </label>
          <input 
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            type="text" 
            name="name" 
            value={formData.name} 
            onChange={handleChange} 
          />
          {errors.name && <span className="text-red-500 text-xs">{errors.name}</span>}
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="email">
            Email:
          </label>
          <input 
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            type="email" 
            name="email" 
            value={formData.email} 
            onChange={handleChange} 
          />
          {errors.email && <span className="text-red-500 text-xs">{errors.email}</span>}
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="password">
            Password:
          </label>
          <input 
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            type="password" 
            name="password" 
            value={formData.password} 
            onChange={handleChange} 
          />
          {errors.password && <span className="text-red-500 text-xs">{errors.password}</span>}
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="gender">
            Gender:
          </label>
          <select 
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            name="gender" 
            value={formData.gender} 
            onChange={handleChange} 
          >
            <option value="">Select Gender</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
          </select>
          {errors.gender && <span className="text-red-500 text-xs">{errors.gender}</span>}
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="dob">
            Date of Birth:
          </label>
          <input 
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            type="date" 
            name="dob" 
            value={formData.dob} 
            onChange={handleChange} 
          />
          {errors.dob && <span className="text-red-500 text-xs">{errors.dob}</span>}
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="fatherName">
            Father's Name:
          </label>
          <input 
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            type="text" 
            name="fatherName" 
            value={formData.fatherName} 
            onChange={handleChange} 
          />
          {errors.fatherName && <span className="text-red-500 text-xs">{errors.fatherName}</span>}
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="motherName">
            Mother's Name:
          </label>
          <input 
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            type="text" 
            name="motherName" 
            value={formData.motherName} 
            onChange={handleChange} 
          />
          {errors.motherName && <span className="text-red-500 text-xs">{errors.motherName}</span>}
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="phoneNumber">
            Phone Number:
          </label>
          <input 
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            type="text" 
            name="phoneNumber" 
            value={formData.phoneNumber} 
            onChange={handleChange} 
          />
          {errors.phoneNumber && <span className="text-red-500 text-xs">{errors.phoneNumber}</span>}
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 text-sm font-bold mb-2" htmlFor="address">
            Address:
          </label>
          <textarea 
            className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            name="address" 
            value={formData.address} 
            onChange={handleChange} 
          />
          {errors.address && <span className="text-red-500 text-xs">{errors.address}</span>}
        </div>
        <div className="mb-4">
          <button 
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" 
            type="submit"
          >
            Submit
          </button>
        </div>
      </form>
    </div>
  );
}

export default App;