import Image from "next/image";
import Search from "../ui/search";
import { fetchFilteredItems } from "../lib/data";
import { Item } from "../lib/definitions";
import styles from '../ui/styles.module.css';
import ItemList from "../ui/ItemList";
import History from "../ui/Hystory";
import { Box } from "@mui/material";
import { Suspense } from "react";

export default async function Items({
  searchParams,
}: {
  searchParams?: {
    search?: string;
  };
}) {
  const search = searchParams?.search || '';
  console.log(search);
  const items = await fetchFilteredItems(search);
  console.log(items);
  return (
    <>
      <Suspense>
        <Search placeholder={"Search"} />
      </Suspense>
      <Box sx={{
        display: 'flex',
        minHeight: '100vh',
        flexDirection: 'column',
        justifyContent: 'space-between',
        alignItems: 'flex-end',
        p: 6
      }}>
        <Box sx={{
          zIndex: 10,
          maxWidth: '5xl',
          width: '100%',
          display: 'flex',
          justifyContent: 'space-between',
          fontFamily: 'monospace',
          fontSize: 'sm'
        }}>
          <ItemList items={items} />
        </Box>
        <History />
      </Box>
    </>

  );
}
