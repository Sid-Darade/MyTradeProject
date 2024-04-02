import React, { useState } from 'react';
import axios from 'axios'; // Make sure axios is imported
import Swal from "sweetalert2";

const Login = (props) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const addData = async (event) => { // Changed 'add' to 'event' for clarity
    event.preventDefault(); // Prevent default form submission
    let user = {
      email: email,
      password: password,
    };

    // Validate email and password
    if (email.trim() === "" || password.trim() === "") {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "All fields Required !!! ",
      });
      return; // Exit function early if fields are empty
    }

    try {
      let result = await axios.post(`http://localhost:8080/admin/userLogin`, user);
      console.log("hello", result.data);

      if (result.data.data === null || result.data.data === "") {
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: "Invalid User",
        });
      } else {
        sessionStorage.setItem("email", result.data.data.email);
        sessionStorage.setItem("firstName", result.data.data.firstName);
        sessionStorage.setItem("lastName", result.data.data.lastName);
        sessionStorage.setItem("role", result.data.data.role);
        sessionStorage.setItem("status", result.data.data.status);
        sessionStorage.setItem("balance", result.data.data.balance);
        sessionStorage.setItem("panNumber", result.data.data.panNumber);
        sessionStorage.setItem("contactNumber", result.data.data.contactNumber);

        if (result.data.data.status === "Active") {
          if (result.data.data.empId === "ADMIN") {
            Swal("Login Successfully!", "success");
            window.location.href = "/adminhome";
          } else {
            Swal("Login Successfully!", "success");
            window.location.href = "/consumerhome";
          }
        } else {
          Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "You are temporarily blocked! Please contact admin",
          });
        }
      }
    } catch (error) {
      console.error("Error:", error);
      // Handle error, maybe show an error message to the user
    }
  };

  return (
    <div className="Auth-form-container">
      <form className="Auth-form" onSubmit={addData}>
        <div className="Auth-form-content">
          <h3 className="Auth-form-title">Sign In</h3>
          <div className="form-group mt-3">
            <label>Email Id</label>
            <input
              type="text" // Corrected type to 'text'
              className="form-control mt-1"
              placeholder="Enter your id"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </div>
          <div className="form-group mt-3">
            <label>Password</label>
            <input
              type="password"
              className="form-control mt-1"
              placeholder="Enter password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </div>
          <div className="d-grid gap-2 mt-3">
            <button type="submit" className="btn btn-primary">
              Submit
            </button>
          </div>
          <p className="forgot-password text-right m-2">
            Forgot <a href="#">password?</a>
          </p>
          <p className="register text-right m-2">
            Need an <a href="/register">account?</a>
          </p>
        </div>
        
      </form>
    </div>
  );
};

export default Login;