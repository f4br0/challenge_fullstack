import '@testing-library/jest-dom'
import { fireEvent, render } from '@testing-library/react'
import History from './Hystory';
import { historyStore } from '../hooks/hystory';

jest.mock('../hooks/hystory', () => ({
  historyStore: jest.fn(),
}));

describe('History', () => {
  it('renders correctly', () => {
    const mockHistory = ['item1', 'item2', 'item3'];
    (historyStore as unknown as jest.Mock).mockReturnValue({ history: mockHistory });

    const { getByText } = render(<History />);

    mockHistory.forEach(item => {
      expect(getByText(item)).toBeInTheDocument();
    });
  });
});