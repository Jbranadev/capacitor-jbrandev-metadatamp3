export interface metadatamp3Plugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
