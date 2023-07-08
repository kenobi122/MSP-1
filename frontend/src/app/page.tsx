import Layout2 from "./components/Layout/layout2"
import Register from "./components/registerForm"

export const metadata = {
  title: 'home',
  description: 'xxx'
}


export default function Home() {
  return (
    <Layout2>
      <h1 className="text-blue-600/100">Hello, Next.js!</h1>
    </Layout2>

  )
}
