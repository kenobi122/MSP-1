import Layout from "@/components/Layout/layout1";

export default function Page() {
  return (
    <>
      <p>djdjj</p>
    </>
  );
}

Page.getLayout = function getLayout(page) {
  return(
    <Layout>
      {page}
    </Layout>
  )
}
