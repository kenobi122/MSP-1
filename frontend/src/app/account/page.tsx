import { NextPage } from "next";
import Register from "../components/registerForm";
import Layout2 from "../components/Layout/layout2";

const Index: NextPage = () => {

  return (
    <Layout2>
          <h1 className="text-blue-600/100">Hello, Next.js!</h1>

      <Register></Register>

    </Layout2>
  );
};

export default Index;
