import { fetchItem } from "@/app/lib/data";
import { Item } from "@/app/lib/definitions";
import ItemCard from "@/app/ui/Item";

export default async function Item({
  params: { itemId },
}: {
  params: {
    itemId: string;
  };
}) {
  const item = await fetchItem(itemId);
  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-24">
      <div className="z-10 max-w-5xl w-full items-center justify-between font-mono text-sm lg:flex">
        <ItemCard item={item} />
      </div>
    </main>
  );
}