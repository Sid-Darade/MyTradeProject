import React, { useState } from "react";
import { Form, FormGroup, Input, Button, Container } from "reactstrap";
import axios from "axios";
import './register.css';
//import Header from "./Header";
//import Footer from "./Footer";
import { Link } from "react-router-dom";
import swal from "sweetalert2";

const Register = () => {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [role, setRole] = useState("");
    const [contactNumber, setContactNumber] = useState("");
    const [panNumber, setPanNumber] = useState("");
    const [balance, setBalance] = useState("");
    const [status, setStatus] = useState("");
  
    const registerUser = (data) => {
      axios.post(`http://localhost:8080/admin/register`, data).then(
        (response) => {
          clearFields();
          swal
            .fire({
              icon: "Success",
              title: "Hurreh!!!",
              text: "You have Registered Succesfully",
              timer: 5000,
              showConfirmButton: true,
            })
            .then(function () {
              window.location.href = "./login";
            });
        },
        (error) => {
          console.log(error);
  
          alert(
            " ERROR : Failed to Register or Email Already Registered with us!!!"
          );
        }
      );
    };
  
    let user = {
      firstName: firstName,
      lastName: lastName,
      email: email,
      contact: contactNumber,
      panNumber: panNumber,
      balance: balance,
      status: status,
      password: password,
      role: role,
    };
  
  
    function clearFields() {
      setFirstName("");
      setLastName("");
      setEmail("");
      setContactNumber("");
      setPanNumber("");
      setBalance("");
      setStatus("");
      setPassword("");
      setRole("");
    }
  
    function clearErrors() {
      document.getElementById("firstname").classList.remove("is-invalid");
      // setFirstName("");
      document.getElementById("lastname").classList.remove("is-invalid");
      // setLastName("");
    }
  
    let validate = () => {
      if (
        firstName() === "" ||
        lastName.trim() === "" ||
        email.trim() === "" ||
        contactNumber.trim() === "" ||
        panNumber.trim()==="" ||
        balance.trim()==="" ||
        status.trim === "" ||
        password.trim() === ""
      ) {
        swal.fire("All fields are  required");
      } else if (
        firstName.search(/^[a-zA-Z ]*$/) < 0 ||
        firstName.length < 2 ||
        firstName.length > 20
      ) {
        document.getElementById("firstname").classList.add("is-invalid");
        swal.fire(
          "First Name must have length of minimum 2 and maximum 20 Characters"
        );
      } else if (
        lastName.search(/^[a-zA-Z ]*$/) < 0 ||
        lastName.length < 2 ||
        lastName.length > 20
      ) {
        document.getElementById("lastname").classList.add("is-invalid");
        swal.fire(
          "Last Name must have length of minimum 2 and maximum 20 Characters"
        );
      } else if (
        email === "" ||
        email.search(/^[a-zA-Z0-9._]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/) < 0
      ) {
        document.getElementById("Email").classList.add("is-invalid");
        setEmail("Enter valid Email ID");
      } else if (contactNumber === "" || contactNumber.search(/^[789][0-9]{9}$/) < 0) {
        document.getElementById("contactNumber").classList.add("is-invalid");
        swal.fire(
          "Enter valid Mobile Number of 10 digit and Remember Should Start with '7'or'8'or'9'"
        );
      } else if (panNumber === "") {
        document.getElementById("panNumber").classList.add("is-invalid");
        setPanNumber("Enter pancard number");
      // } else if (State === "") {
      //   document.getElementById("State").classList.add("is-invalid");
      //   setState("Enter State");
      } else if (
        password === "" ||
        password.search(
          /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/
        ) < 0 ||
        password.length < 6
      ) {
        document.getElementById("password").classList.add("is-invalid");
        swal.fire(
          "Enter a password with atleast 8 characters and must include 1 capital, 1 number and 1 special character"
        );
      } else registerUser(user);
    };
  
    return (
      <>
       {/* <Header></Header> */}
        <div className="vh-100 d-flex reg  p-1">
          <div className="m-auto w-50 pt-2 ps-5 pe-5 pb-2  align-self-center text-white reg-form">
            <h2 className="text-center fw-bold mb-3" style={{ color: "#ba8b00" }}>
              Register Here
            </h2>
  
            <Form className="row g-3 mt-1">
              <div className="col-md-6">
                <label for="name" className="form-label fs-6">
                  First Name
                </label>
                <Input
                  type="text"
                  className="form-control"
                  onChange={(e) => {
                    setFirstName(e.target.value);
                  }}
                  placeholder="Enter First Name "
                  name="firstname"
                  id="firstname"
                  onFocus={clearErrors}
                  value={firstName}
                  required
                />
              </div>
              <div className="col-md-6">
                <label for="name" className="form-label fs-6">
                  Last Name
                </label>
                <Input
                  className="form-control"
                  type="text"
                  onChange={(e) => {
                    setLastName(e.target.value);
                  }}
                  placeholder="Enter Last Name"
                  name="lastname"
                  id="lastname"
                  onFocus={clearErrors}
                  value={lastName}
                />
              </div>
  
              <div className="col-md-6">
                <label for="name" className="form-label fs-6">
                  Email
                </label>
                <Input
                  className="form-control"
                  type="email"
                  onChange={(e) => {
                    setEmail(e.target.value);
                  }}
                  placeholder="Enter Email"
                  name="Email"
                  id="Email"
                  //onFocus={clearErrors}
                  value={email}
                  title="example:abc@gmail.com"
                  required
                  style={{ heigh: 200 }}
                />
              </div>
  
              <div className="col-md-6">
                <label for="name" className="form-label fs-6">
                  Contact No
                </label>
                <Input
                  className="form-control"
                  type="text"
                  onChange={(e) => {
                    setContactNumber(e.target.value);
                  }}
                  placeholder="Enter Phone No"
                  name="cantactNumber"
                  id="cantactNumber"
                  //onFocus={clearErrors}
                 
                  title="8896523015"
                  required
                  style={{ heigh: 200 }}
                  value={contactNumber}
                />
              </div>
  
              <div className="col-md-6">
                <label for="name" className="form-label fs-6">
                  Pan Number
                </label>
                <Input
                  className="form-control"
                  type="text"
                  onChange={(e) => {
                    setPanNumber(e.target.value);
                  }}
                  placeholder="Enter Your Address"
                  name="panNumber"
                  id="panNumber"
                  maxLength="40"
                  title="mumbai"
                  required
                  style={{ heigh: 200 }}
                  //onFocus={clearErrors}
                  value={panNumber}
                />
              </div>
              
              <div className="col-md-6">
                <label for="name" className="form-label fs-6">
                  Password
                </label>
                <Input
                  className="form-control"
                  type="password"
                  onChange={(e) => {
                    setPassword(e.target.value);
                  }}
                  placeholder="Enter Password"
                  name="Password"
                  id="Password"
                  //onFocus={clearErrors}
                  value={password}
                  required
                  style={{ heigh: 200 }}
                />
              </div>
  
              <Container className="text-center my-3">
                <Button color="success " outline onClick={validate}>
                  Register
                </Button>
                <Button type="reset" color="warning ml-3 " outline>
                  Clear
                </Button>
              </Container>
              <div className="col-md-12 text-center">
                <h4 className="fs-6 custom-text-color">
                  Already have an
                  <Link to="/login" href="#" className="text-decoration-none m-2">
                     Account?
                  </Link>
                </h4>
              </div>
            </Form>
          </div>
        </div>
                {/* <Footer></Footer>  */}
               

      </>
    );
  };
  
  export default Register;