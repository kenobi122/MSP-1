import { ReactNode } from "react";
import HeaderComponent from "../Header/header";
import FooterComponent from "../Footer/footer";

type Props = {
  children: ReactNode;
};

const Layout2 = ({ children}: Props) => (
  <>
    <HeaderComponent></HeaderComponent>
    <main>{children}</main>
    <FooterComponent></FooterComponent>
  </>
);

export default Layout2;