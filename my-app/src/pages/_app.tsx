import "@/styles/globals.css";
import PageWithLayoutType from "@/tsFile/PageWithLayout";
import type { AppProps } from "next/app";
import { ReactElement } from "react";

export default function App({ Component, pageProps }: AppProps) {
  return <Component {...pageProps} />;
}
