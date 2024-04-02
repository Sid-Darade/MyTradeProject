import { useEffect } from "react";

export default function ConsumerHome() {
  useEffect(() => {
    if (
      sessionStorage.getItem("role") === "null" ||
      sessionStorage.getItem("role") != "CONSUMER"
    ) {
      window.location.href = "/login";
    }
  }, []);
  let y = localStorage.getItem("email");
  return (

    <h1>this is consumer Home</h1>
    /* <div>
     <AdminNavbar />

      <Carausol></Carausol>
      <Cards></Cards>
      <AdminFooter />
    </div> */
  );
}