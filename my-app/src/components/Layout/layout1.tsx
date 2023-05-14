import { ReactElement } from "react";
import HeaderComponent from "../Header/header";
import FooterComponent from "../Footer/footer";

export default function Layout({ children }: { children: ReactElement }) {
  return (
    <>
      <HeaderComponent></HeaderComponent>
      <main>{children}</main>
      <FooterComponent></FooterComponent>
    </>
  );
}
