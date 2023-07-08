'use client';

import { NextPage } from "next";
import { Props } from "next/script";
import { ChangeEvent, FormEvent, useState } from "react";

interface IMyProps {
    open: boolean,
}

const RegisterBlock: React.FC<IMyProps> = (props: IMyProps) => {


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
        copy.password = event.target.value;
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

    async function handleSubmit(
        event: FormEvent<HTMLButtonElement>
    ): Promise<any> {
        event.preventDefault;

        console.log(formLogin)

        // const response = await fetch(endpoint, options);
        let res = await fetch(`http://localhost:8080/api/account/login`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(formLogin),
        });
        const result = await res.json();
        console.log(result.body);
    }

   

    if(props.open){
        return (
       
            <>
                <div id ="loginModal" className="fixed top-0 left-0 right-0 z-50 bg-black/40" >
                    <p>Account</p>
                    <form id="login-form">
                        <label className="">Username:</label>
                        <input
                            type="text"
                            id="username"
                            name="username"
                            onChange={handleUsernameInput}
                            className="divide-amber-900"
                        ></input>
                        <br></br>
                        <label className="">Password:</label>
                        <input
                            type="password"
                            id="password"
                            name="password"
                            onChange={handlePassWordInput}
                            className="divide-amber-900"
                        ></input>
                        <br></br>
                    </form>
                    <button id="login-button" className="bg-green-50" onClick={handleSubmit}>
                        Submit
                    </button>
                </div>
            </>
        )
    }
    return(
        <>
        </>
    )
    
};

export default RegisterBlock;