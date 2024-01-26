import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import { Item } from '../lib/definitions';

export default function ItemCard({ item } : { item: Item}) {
  return (
    <Card sx={{ minWidth: 275 }}>
      <CardContent>
        <Typography variant="h5" component="div">
          {item.name}
        </Typography>
        <Typography variant="body2">
          {item.description}
        </Typography>
      </CardContent>
    </Card>
  );
}