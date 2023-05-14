import AdminLayout from "@/components/Layout/AdminLayout";
import MainLayout from "@/components/Layout/MainLayout";
import { NextPage } from "next";
import { ReactElement, ReactNode } from "react";

export type PageWithMainLayout = NextPage & { layout: typeof MainLayout };

export type PageWithAminLayout = NextPage & { layout: typeof AdminLayout };

export type PageWithLayoutType = | PageWithAminLayout | PageWithAminLayout;

export type LayoutProps = ({
  children,
}: {
  children: ReactNode;
}) => ReactElement;

export default PageWithLayoutType;
