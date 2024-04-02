import { useEffect } from "react";

export default function AdminHome() {
  useEffect(() => {
    if (
      sessionStorage.getItem("role") === "null" ||
      sessionStorage.getItem("role") != "ADMIN"
    ) {
      window.location.href = "/login";
    }
  }, []);
  let y = localStorage.getItem("email");
  return (

    <h1>this is admin Home</h1>
    /* <div>
     <AdminNavbar />

      <Carausol></Carausol>
      <Cards></Cards>
      <AdminFooter />
    </div> */
  );
}
