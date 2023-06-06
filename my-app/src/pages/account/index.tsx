import Layout2 from "@/components/Layout/layout2";
import { NextPage } from "next";
import styles from "@/styles/account.module.css";
import { ChangeEvent, FormEvent, useState } from "react";
import { json } from "stream/consumers";

const Index: NextPage = () => {
  interface formLogin {
    username: String;
    password: String;
  }
  const [formLogin, useFormLogin] = useState<formLogin>({
    username: "",
    password: "",
  });

  const handleUsernameInput = (event: ChangeEvent<HTMLInputElement>): void => {
    const copy = { ...formLogin };
    copy.username = event.target.value;

    useFormLogin(copy);
  };

  const handlePassWordInput = (event: ChangeEvent<HTMLInputElement>): void => {
    const copy = { ...formLogin };
    const password = event.target.value;
    useFormLogin(copy);
  };

  const endpoint = "http://localhost:8080/api/account/login";
  const options = {
    // The method is POST because we are sending data.
    method: "POST",
    // Tell the server we're sending JSON.
    headers: {
      "Content-Type": "application/json",
    },
    // Body of the request is the JSON data we created above.
    body: JSON.stringify(formLogin),
  };

 

  async function handleSubmit(event: FormEvent<HTMLButtonElement>): Promise<any> {
    event.preventDefault;
  
    // const response = await fetch(endpoint, options);
    let res = await fetch(`http://localhost:8080/api/account/login`, {
      method: "POST",
      headers: {
          "Content-Type": "application/json"
      },
      body:JSON.stringify(formLogin)
  })
    const result = await res.json();
    console.log(`Is this your full name: ${result}`);
  
  }

  return (
    <Layout2>
      <p>Account</p>
      <form id="login-form">
        <label>Username:</label>
        <input
          type="text"
          id="username"
          name="username"
          onChange={handleUsernameInput}
        ></input>
        <br></br>
        <label>Password:</label>
        <input
          type="password"
          id="password"
          name="password"
          onChange={handlePassWordInput}
        ></input>
        <br></br>
    
      </form>
      <button id="login-button" onClick={handleSubmit}>
          Submit
        </button>
    </Layout2>
  );
};

export default Index;
