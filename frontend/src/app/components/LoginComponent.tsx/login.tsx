'use client'
import { NextPage } from "next";
import Register from "../registerForm";
import { useState } from "react";
import RegisterBlock from "../registerBlock";

const Login: NextPage = () => {
     const[showModal, setShowModal] = useState<boolean>(false);

    return (
        <>
            <a  href="/account" className="mr-6">SIGNIN</a>
            <a href="/signup" className="mr-6">SIGNUP</a>
            <button id="btn-1" onClick={() => setShowModal(true)}> show modal</button>
            <RegisterBlock open={showModal}></RegisterBlock>
        </>
    )
}

export default Login;