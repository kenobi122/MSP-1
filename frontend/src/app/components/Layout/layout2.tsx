import { ReactNode } from "react";
import HeaderComponent from "../Header/header";
import FooterComponent from "../Footer/footer";
// import "@/styles/globals.css";

type Props = {
  children: ReactNode;
};

const Layout2 = ({ children }: Props) => (
  <>
    <HeaderComponent></HeaderComponent>
    <main className="bg-pink-50">{children}</main>
    <section className="bottom-0 absolute">
      <FooterComponent></FooterComponent>
    </section>

  </>
);

export default Layout2;