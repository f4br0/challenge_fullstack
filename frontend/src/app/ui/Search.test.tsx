import '@testing-library/jest-dom'
import { fireEvent, render } from '@testing-library/react'
import Search from './search';
import { usePathname, useRouter, useSearchParams } from 'next/navigation';
import { useDebouncedCallback } from 'use-debounce';
import { historyStore } from '../hooks/hystory';

jest.mock('next/navigation', () => ({
  usePathname: jest.fn(),
  useRouter: jest.fn(),
  useSearchParams: jest.fn(),
}));

jest.mock('use-debounce', () => ({
  useDebouncedCallback: jest.fn(),
}));

jest.mock('../hooks/hystory', () => ({
  historyStore: jest.fn(),
}));

describe('Search', () => {
  it('renders correctly', () => {
    (useSearchParams as jest.Mock).mockReturnValue(new URLSearchParams());
    (usePathname as jest.Mock).mockReturnValue('/items');
    (useRouter as jest.Mock).mockReturnValue({ replace: jest.fn() });
    (useDebouncedCallback as jest.Mock).mockReturnValue([jest.fn()]);
    (historyStore as unknown as jest.Mock).mockReturnValue({ add: jest.fn() });

    const { getByPlaceholderText } = render(<Search placeholder="Search items" />);

    expect(getByPlaceholderText('Search items')).toBeInTheDocument();
  });

});