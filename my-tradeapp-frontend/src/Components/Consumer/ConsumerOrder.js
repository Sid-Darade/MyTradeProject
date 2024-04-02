import axios from "axios";
import React, { useContext,useState,useEffect } from "react";

const ConsumerOrder = (props) => {
  const { stocks, onAdd, onRemove } = props;
  const pricePerUnit = cartItems.reduce((a, c) => a + c.qty * c.price, 0);
  const taxPrice = pricePerUnit * 0.15;
  const brokrage = 20;
  const totalPrice = pricePerUnit + taxPrice + brokrage;

  let city = sessionStorage.getItem("city");
  
  let firstName = sessionStorage.getItem("firstName");
  let lastName = sessionStorage.getItem("lastName");
  let contactNumber = sessionStorage.getItem("contactNumber");
  let panNumber = sessionStorage.getItem("panNumber");
  let balance = sessionStorage.getItem("balance");
  
  console.log("-----------");



  console.log("-----------");
  const saveOrder = () => {
    console.log(sessionStorage.getItem("role"));
    let email = sessionStorage.getItem("email");
    if (sessionStorage.getItem("role") === null) {
      return (window.location.href = "/login");
    }
    cartItems.forEach((element) => {
      console.log(element);
    });

    // console.log("-----------");
    // let sentOrder = {
    //   productName: cartItems.map(item => item.stockName).toString(),

    //    //productName: cartItems[0].productName, 
     
    //   pricePerUnit: pricePerUnit,
    //   taxPrice: taxPrice,
    //   brokrage: brokrage,
    //   totalPrice: totalPrice,
    //   address: Address,
    //   pincode: pincode,
    //   city: city,
    //   email: email,
    //   firstName: firstName,
    //   lastName: lastName,
    //   phone: phone,
    //   state: state,
    // };
    // console.log(sentOrder.productName);
    // console.log(cartItems.productName);
//     axios
//       .post(
//         `http://localhost:8080/consumer/saveOrder/${email}`,
//         sentOrder
//       )
//       .then(
//         (response) => {
//           alert("SUCCESS : order added ");
//           window.location.reload();
//           console.log(response.data);
//         },
//         (error) => {
//           console.log(error);
//           alert(" ERROR : order failed");
          
//         }
//       );
//   };

  return (
    <div>
      {/* <section className="py-4 container"> */}
      <div className="row justify-content-center text-center">
        <div className="col-6">
          <h1 className="text-center">Cart</h1>
          <h5 className="text-center text-info">
            {cartItems.length === 0 && (
              <div className="text-center">Cart is Empty</div>
            )}
          </h5>

          {cartItems.map((item) => (
            <div key={item.p_Id}>
              <img src={item.imageName} height="150" width={200}></img>
             {/* <div>{item.productNames}</div> */}
             <div>{item.productName}</div> 
              <div >
                <button onClick={() => props.onAdd(item)}  style={{ margin: '5px' }}>add</button>
            
                <button onClick={() => props.onRemove(item)}>remove</button>
              </div>
              <div>
                {item.qty}x Rs.{item.price}
              </div>
            </div>
          ))}
        </div>
      </div>
      {cartItems.length !== 0 && (
        <>
          <hr></hr>
          <div className="row mb-2">
            <div className="col-2">Items Price</div>
            <div className="col-1 ">Rs.{pricePerUnit.toFixed(2)}</div>
          </div>
          <div className="row mb-2">
            <div className="col-2">Tax Price</div>
            <div className="col-1 text-right">RS.{taxPrice.toFixed(2)}</div>
          </div>
          <div className="row mb-2">
            <div className="col-2">Shipping Price</div>
            <div className="col-1 text-right">
              RS.{brokrage.toFixed(2)}
            </div>
          </div>

          <div className="row">
            <div className="col-2">
              <strong>Total Price</strong>
            </div>
            <div className="col-1 text-right">
              <strong>Rs.{totalPrice.toFixed(2)}</strong>
            </div>
          </div>
          <hr />
          <div className="row">
            <button onClick={saveOrder}>Order It</button>
          </div>
        </>
      )}
      {/* </section> */}
    </div>
  );
};

export default ConsumerOrder;