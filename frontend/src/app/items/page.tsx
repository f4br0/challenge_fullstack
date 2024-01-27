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
  const items = await fetchFilteredItems(search);
  return (
    <div className="flex">
      <div className="flex-grow">
        <Suspense>
          <Search placeholder={"Search"} />
        </Suspense>

        <ItemList items={items} />
      </div>

      <div className="w-64 ml-24">
        <History />
      </div>
    </div>

  );
}
