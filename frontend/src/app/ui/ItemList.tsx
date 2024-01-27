import * as React from 'react';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';
import { Item } from '../lib/definitions';
import { ListItemButton } from '@mui/material';
import Link from 'next/link';

export default function ItemList({ items }: { items: Item[] }) {

  return (
    <List>
      {items.length === 0 && (<p>no results</p>)}
      {items.map((item, index) => (
        <Link
          key={`/items/${item.id}`}
          href={`/items/${item.id}`}
        >

          <ListItem disablePadding key={index}>
            <ListItemButton>
              <ListItemText
                primary={`${item.id} - ${item.name}`}
              />
            </ListItemButton>
          </ListItem>
        </Link>
      ))}
    </List>
    
  );
}