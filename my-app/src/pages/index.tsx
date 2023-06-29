import Head from "next/head";
import { Inter } from "next/font/google";

import FooterComponent from "../components/Footer/footer";
import HeaderComponent from "@/components/Header/header";

const inter = Inter({ subsets: ["latin"] });

export default function Home() {
  return (
    <>
      <Head>
        <title>my new app</title>
      </Head>
      <HeaderComponent></HeaderComponent>
      <main>
        <p className="text-blue-600"> here is the first screenxx </p>
      </main>
      <FooterComponent></FooterComponent>
    </>
  );
}
