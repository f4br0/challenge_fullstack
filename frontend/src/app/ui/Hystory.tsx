'use client';

import { Box, List, ListItem, ListItemText } from "@mui/material";
import { historyStore } from "../hooks/hystory";

export default function History() {

  const { history } = historyStore();
  { console.log(history) }
  return (
    <Box
      sx={{
        width: '100%',
        maxWidth: 360,
        bgcolor: 'background.paper',
      }}
    >
      <List component="nav" aria-label="main mailbox folders">
        {history.map((item, index) => (
          <ListItem key={index}>
            <ListItemText primary={item} />
          </ListItem>
        ))}
      </List>
    </Box>
  );

}