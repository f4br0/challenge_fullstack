const CACHE_LIMIT_DETAIL = 999;
export async function fetchFilteredItems(
  search: string,
) {
  try {
    const response = await fetch(`${process.env.API_URL}/api/item?search=${search}&limit=${process.env.LIMIT_ITEM}`);
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
    const response = await fetch(`${process.env.API_URL}/api/item/${itemId}`);
    return await response.json();
  } catch (error) {
    console.error('Fetch Error:', error);
    throw new Error('Failed to fetch item by id.');
  }
}

export async function fetchItemsId() {
  try {
    const response = await fetch(`${process.env.API_URL}/api/item?search=&limit=${CACHE_LIMIT_DETAIL}`);
    return await response.json();
  } catch (error) {
    console.error('Fetch Error:', error);
    throw new Error('Failed to fetch list items.');
  }
}