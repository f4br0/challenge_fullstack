import Image from "next/image";
import Search from "./ui/search";
import { Box, Typography } from "@mui/material";
import { Suspense } from "react";
// import { usePathname } from "next/navigation";

export default function Home() {


  return (
    // You could have a loading skeleton as the `fallback` too
    <Suspense>
      <Search placeholder={"Search"} />
    </Suspense>

  );
}
