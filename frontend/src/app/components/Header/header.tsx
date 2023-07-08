import { NextPage } from "next"
import Login from "../LoginComponent.tsx/login"
import Register from "../registerForm"
import { useState } from "react"


export default function HeaderComponent() {
    
    
    return (
        <>
         <nav className="flex border-solid border-black border-2">
            <a href="/" className="text-red-950 mr-6">Home</a>
            <a href="/account" className="mr-6">Account</a>
            <a href="/prodcut" className="mr-6">Product</a>
            <a href="/market" className="mr-6">Market</a>
            <a href="/market" className="mr-6">Market</a>
            <Login />
        </nav>
        </>
       
    )
}



