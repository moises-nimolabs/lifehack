export interface Goal {
  id: number;
  name: string;
  sequence: number;
  goals: Goal[];
  /* specific view implementation to handle expantion */
  expanded: boolean;
  canExpand: () => boolean;
}
