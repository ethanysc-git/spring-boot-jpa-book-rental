import { Inventory } from './inventory';
export interface Book {
  id: string;
  author: string;
  image: string;
  title: string;
  availableRecord: Inventory[];
  borrowedRecord: Inventory[];
  availableBalance: number;
  borrowedAmount: number;
}
