'use client';

import { Box, List, ListItem, ListItemText, ListSubheader } from "@mui/material";
import { historyStore } from "../hooks/hystory";

export default function History() {

  const { history } = historyStore();
  return (
    <Box
      sx={{
        width: '100%',
        bgcolor: 'background.paper',
      }}
    >
      <List>
      <ListSubheader component="div" id="list-subheader" sx={{ fontSize: '1.3rem' }}>
            History search
          </ListSubheader>
        {history.map((item, index) => (
          <ListItem key={index}>
            <ListItemText primary={item} sx={{ fontSize: '0.5rem' }}/>
          </ListItem>
        ))}
      </List>
    </Box>
  );

}