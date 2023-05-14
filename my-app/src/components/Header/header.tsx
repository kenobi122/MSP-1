import styles from "@/styles/header.module.css"

export default function HeaderComponent(){
    return (        
        <nav className={styles.navigation}>
            <a href="/" >Home</a>
            <a href="/account">Account</a>
            <a href="/prodcut">Product</a>
            <a href="/market">Market</a>
            <a href="/king">King</a>
        </nav>
    )
}