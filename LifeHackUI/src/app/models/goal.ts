export interface Goal {
  id: number;
  name: string;
  /* specific view implementation to handle expantion */
  expanded: boolean;
  goals: Goal[];
}
