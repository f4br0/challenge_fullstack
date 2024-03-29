import { create } from 'zustand'

interface State {
  history: string[];
  add: (search : string) => void;
}
export const historyStore = create<State>(set => ({
  history: [],
  add: (search ) => set(state => ({ history: [search, ...state.history].slice(0, 6)})), 
}));
