const ITEMS_LIMIT = 4;
export async function fetchFilteredItems(
  search: string,
) {
  try {
    const response = await fetch(`http://localhost:5001/api/item?search=${search}&limit=${ITEMS_LIMIT}`);
    return await response.json();
  } catch (error) {
    console.error('Fetch Error:', error);
    throw new Error('Failed to fetch items.');
  }
}

export async function fetchItem(
  itemId: string,
) {
  try {
    const response = await fetch(`http://localhost:5001/api/item/${itemId}`);
    return await response.json();
  } catch (error) {
    console.error('Fetch Error:', error);
    throw new Error('Failed to fetch item by id.');
  }
}