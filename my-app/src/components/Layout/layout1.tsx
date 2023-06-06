import { ReactElement, ReactNode } from "react";
import HeaderComponent from "../Header/header";
import FooterComponent from "../Footer/footer";
import { NextPage } from "next";


type Props = {
  children: ReactNode;
};

export default function Layout1({children} : Props) {
  return (
    <>
      <HeaderComponent></HeaderComponent>
      <main>{children}</main>
      <FooterComponent></FooterComponent>
    </>
  );
}
