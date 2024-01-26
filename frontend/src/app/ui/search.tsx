'use client';

import { TextField } from '@mui/material';
import { usePathname, useRouter, useSearchParams } from 'next/navigation';
import { useDebouncedCallback } from 'use-debounce';
import { historyStore } from '../hooks/hystory';

const PARAM_SEARCH = 'search';

export default function Search({ placeholder }: { placeholder: string }) {

  const { add } = historyStore();
  const searchParams = useSearchParams();
  const pathname = usePathname();
  const { replace } = useRouter();

  const handleSearch = useDebouncedCallback((term: string) => {
    const params = new URLSearchParams(searchParams);
    if (term) {
      params.set(PARAM_SEARCH, term);
      add(term)
      replace(`${pathname.replace(/items/g, '')}items?${params.toString()}`);
    } else {
      params.delete(PARAM_SEARCH);
      replace(`${pathname}`);
    }
  }, 300);


  return (
    <TextField
      type="search"
      label="Search"
      variant="outlined"
      placeholder={placeholder}
      defaultValue={searchParams.get(PARAM_SEARCH)?.toString()}
      onChange={(e) => {
        handleSearch(e.target.value);
      }}
    />
  );
}