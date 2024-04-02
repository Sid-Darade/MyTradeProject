import './App.css';
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle.min.js";
import { BrowserRouter, Routes, Route } from "react-router-dom"

import Login from "./Components/Login"
import AdminHome from "./Components/Admin/AdminHome"
import ConsumerHome from "./Components/Consumer/ConsumerHome"
import Home from "./Components/Home"
import RegisterUser from "./Components/Register"
function App() {
  return (
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<Home></Home>} />
      <Route path="/login" element={<Login />} />
      <Route path="/admin" element={<AdminHome />}/>
      <Route path="/consumer" element={<ConsumerHome />}/>
      <Route path="/register" element={<RegisterUser />}/>
    </Routes>
  </BrowserRouter> 
  );
}

export default App;
