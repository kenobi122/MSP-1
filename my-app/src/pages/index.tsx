import Head from "next/head";
import Image from "next/image";
import { Inter } from "next/font/google";
import styles from "@/styles/Home.module.css";

import FooterComponent from "../components/Footer/footer";
import HeaderComponent from "@/components/Header/header";
import { NextPage } from "next";

const inter = Inter({ subsets: ["latin"] });

export default function Home() {
  return (
    <>
      <Head>
        <title>my new app</title>
      </Head>
      <HeaderComponent></HeaderComponent>
      <main className={styles.main}>
        <p> here is the first screen </p>
      </main>
      <FooterComponent></FooterComponent>
    </>
  );
}
